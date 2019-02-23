const confi = require('./config');
const hm = require('./here_maps_wrapper');



var getTime = (startLatLng, endLatLng) => {
return new Promise((resolve, reject) => {
    hm.configure(confi.config).then(() => {
hm.requestSimpleString(startLatLng, endLatLng).then(
    (body) => {
        resolve(body.response.route[0].summary.trafficTime);
    }, (err) => {
    reject(err);
    });
}, (err) => reject(err));
});
};


getTime("49.9399807,-119.395521", "49.9081381,-119.3917857").then((trafficTime) => {
    console.log(trafficTime);
}, (err) => {
    console.log(err)
});



module.exports = {
    getTime
}