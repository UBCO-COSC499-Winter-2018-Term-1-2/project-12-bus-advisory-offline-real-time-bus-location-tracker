var mongoose = require('mongoose');

mongoose.Promise = global.Promise;
mongoose.connect('mongodb+srv://admin:admin123@clusterdb-vamyo.mongodb.net/test?retryWrites=true' || 'mongodb://localhost:27017/BusAdvisorApp', { useNewUrlParser: true });

module.exports = {mongoose};
