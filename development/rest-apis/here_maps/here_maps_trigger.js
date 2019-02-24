const request = require('request');
const firebase = require('firebase-admin');

const config = require('./config');
const hm = require('./here_maps_wrapper');
firebase.initializeApp(config.firebaseConfig);


var getTime = (startLatLng, endLatLng) => {
return new Promise((resolve, reject) => {
    hm.configure(config.here_maps_config).then(() => {
hm.requestSimpleString(startLatLng, endLatLng).then(
    (body) => {
        resolve(body.response.route[0].summary.trafficTime);
    }, (err) => {
    reject(err);
    });
}, (err) => reject(err));
});
};

var sendRequest = (startLatLng, endLatLng, busStopName) => {
    return new Promise((resolve, reject) => {
        var time = Math.round(getTime(startLatLng, endLatLng)/60);
        if( time <= 100 ) {
            var message = {
                notification: {
                  title: `Your Bus is Arriving Soon`,
                  body: `Your Bus is arriving in approximately ${time} minutes`
                },
                topic: `bus ${busStopName} time ${time}`
              };
              firebase.messaging.send(message).then((response) => {
                // Response is a message ID string.
                console.log('Successfully sent message:', response);
              })
              .catch((error) => {
                console.log('Error sending message:', error);
              });
        }
    });
};


// getTime("49.9399807,-119.395521", "49.9081381,-119.3917857").then((trafficTime) => {
//     console.log(trafficTime);
// }, (err) => {
//     console.log(err)
// });



module.exports = {
getTime,
sendRequest
}
