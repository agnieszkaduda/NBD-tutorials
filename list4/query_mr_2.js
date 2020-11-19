var mapFunction = function () {
	for(var i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance))
	}
};

var reduceFunction = function(key, values) {
    return Array.sum(values);
};

db.people.mapReduce(mapFunction, reduceFunction, {out: "totalBalance"})
printjson(db.totalBalance.find().toArray());

