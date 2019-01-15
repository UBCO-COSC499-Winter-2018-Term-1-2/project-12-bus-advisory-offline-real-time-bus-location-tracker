//var serverless = require('serverless-http');
var cors = require("cors");
//var express = require('express');
//var app = express();
//
//app.get('/', function (req, res) {
//    res.send('Hello World!')
//})
//
//module.exports.handler = serverless(app);

var express = require('express');
var bodyParser = require('body-parser');

var {mongoose} = require('./db/mongoose');
var {Trigger} = require('./models/trigger');

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

//app.listen(3000, () => {
//    console.log('Started on port 3000');
//});
//
module.exports = {app};

//module.exports.handler = serverless(app);
