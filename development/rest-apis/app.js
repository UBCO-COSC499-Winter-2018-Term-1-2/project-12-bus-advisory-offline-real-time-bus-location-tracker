//var serverless = require('serverless-http');
const cors = require("cors");
const express = require('express');
const bodyParser = require('body-parser');
const _ = require('underscore');
const {ObjectID} = require('mongodb');
//var moment = require('moment');

var {mongoose} = require('./db/mongoose');

var {Trigger} = require('./models/trigger');
var {BusLocation} = require('./models/busLocation');
var {TripRequest} = require('./models/tripRequest');

var app = express();

app.use(cors());

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }));

app.use(bodyParser.json());

app.post('/triggers', (req, res) => {
    var trigger = new Trigger({
        userId: req.body.userId,
        tripId: req.body.tripId,
        beaconTrigger: req.body.beaconTrigger
    });

    trigger.save().then((doc) => {
        res.send(doc);
    }, (e) => {
        res.status(400).send(e);
    });
});

app.post('/buslocation', (req, res) => {
    var busLocation = new BusLocation({
        busId: req.body.busId,
        location: {
            type: req.body.location.type,
            coordinates: req.body.location.coordinates
        },
        timestamp: new Date().getTime()
    });

    busLocation.save().then((doc) => {
        res.send(doc);
    }, (e) => {
        res.status(400).send(e);
    });
});

app.post('/triprequest', (req, res) => {
    var tripRequest = new TripRequest({
        userId: req.body.userId,
        tripId: req.body.tripId,
        busId: req.body.busId,
        busStop: req.body.busStop,
        stopLocation: {
            type: req.body.stopLocation.type,
            coordinates: req.body.stopLocation.coordinates
        },
        requestedTime: new Date().getTime(),
        reminderTime: req.body.reminderTime  
    });

    tripRequest.save().then((doc) => {
        res.send(doc);
    }, (e) => {
        res.status(400).send(e);
    });
});

// To get the latest bus location
app.get('/buslocation', (req, res) => {
    BusLocation.find().sort({timestamp:-1}).limit(1).then((buslocation) => {
        res.send({buslocation});
        //    console.log(buslocation);
    }, (e) => {
        res.status(400).send(e);
    });
});

// To check if there's an user at a certain bus stop
// checking if there's a request in last 50 mins
app.get('/triprequest', (req, res) => {
    TripRequest.find({
        requestedTime : 
        { $gte :  new Date(new Date().getTime() - 1000 * 60 * 50) }
    }).then((tripreqs) => {
        const uniqueLocations = _.uniq(tripreqs, (unique) => unique.busStop);
        //        const uniqueStops = tripreqs.filter((user) => user.busStop === "UBCO B");
        //        console.log('reqsloc', uniqueLocations);
        //        console.log('reqs', uniqueStops);
        res.send({uniqueLocations});
    }, (e) => {
        res.status(400).send(e);
    });
});

//app.get('/todos/:id', (req, res) => {
//  var id = req.params.id;
//
//  if (!ObjectID.isValid(id)) {
//    return res.status(404).send();
//  }
//
//  Todo.findById(id).then((todo) => {
//    if (!todo) {
//      return res.status(404).send();
//    }
//
//    res.send({todo});
//  }).catch((e) => {
//    res.status(400).send();
//  });
//});

app.patch('/buslocation/:id', (req, res) => {
    var id = req.params.id;
    var body = _.pick(req.body, 'location');
//    console.log('bd', body.location.coordinates);

    if (!ObjectID.isValid(id)) {
        return res.status(404).send('Please check your id');
    }

    if (body.location.coordinates) {
        body.timestamp = new Date().getTime();

        BusLocation.findByIdAndUpdate(id, {$set: body}, {new: true}).then((newLocation) => {
            if (!newLocation) {
                return res.status(404).send();
            }

            res.send({newLocation});
        }).catch((e) => {
            res.status(400).send(e);
        })
    } else {
        return res.status(404).send('Please check your coordinates');
    }

});



//app.listen(3000, () => {
//    console.log('Started on port 3000');
//});

module.exports = {app};

//module.exports.handler = serverless(app);
