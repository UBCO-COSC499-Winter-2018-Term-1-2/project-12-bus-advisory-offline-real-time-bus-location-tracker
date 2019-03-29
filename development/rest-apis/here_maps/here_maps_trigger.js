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
        resolve(Math.round(body.response.route[0].summary.trafficTime/60));
    }, (err) => {
    reject(err);
    });
}, (err) => reject(err));
});
};

var sendRequest = (startLatLng, endLatLng, busStopName) => {
    return new Promise((resolve, reject) => {
        getTime(startLatLng, endLatLng).then( (time) => {
        if( time <= 100 ) {
            var message = {
                notification: {
                  title: `Your Bus is Arriving Soon`,
                  body: `Your Bus is arriving in approximately ${time} minutes`
                },
                condition: `\'bus${busStopName}time${time}\' in topics`
              };
              firebase.messaging().send(message).then((response) => {
                // Response is a message ID string.
                resolve(response);
                console.log('Successfully sent message:', response);
                firebase.messaging().goOffline();
              })
              .catch((error) => {
                console.log('Error sending message:', error);
                firebase.messaging().goOffline();
              });
        }
      }).catch((err) => reject(err));
  });
};


// getTime("49.9399807,-119.395521", "49.9081381,-119.3917857").then((trafficTime) => {
//     console.log(trafficTime);
// }, (err) => {
//     console.log(err)
// });

// sendRequest("49.9399807,-119.395521", "49.9081381,-119.3917857", "UBCOA").then(() => {
//   console.log("success");
//   process.exit();
// }).catch((err) => {
//   console.log(err);
//   process.exit();
// });



module.exports = {
getTime,
sendRequest
};
