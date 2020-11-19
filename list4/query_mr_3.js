var mapFunction = function () {
	emit(this.job, this.job);
};

var reduceFunction = function(key, values) {
    return key;
};

db.people.mapReduce(mapFunction, reduceFunction, {out: "distinctJobs"});
printjson(db.distinctJobs.find().toArray());