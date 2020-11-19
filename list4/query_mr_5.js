var mapFunction = function () {
	for(var i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, {
            counter: 1,
            balance: parseFloat(this.credit[i].balance)})
	}
};

var reduceFunction = function(key, values){
    var reducedValue = {
        counter: 0,
        balance: 0
    };
    
    for(var i = 0; i < values.length; i++){
        reducedValue.counter += values[i].counter;
        reducedValue.balance += values[i].balance;
    };   
    return reducedValue;
};

var finalizeFunction = function(key, value){
    var result = {
      avgBalance: parseFloat(value.balance/value.counter),
      totalBalance: value.balance
    };
    return result;
};

db.people.mapReduce(mapFunction, reduceFunction, {query: {nationality: "Poland", sex: "Female"}, finalize: finalizeFunction, out: "totalMoney"});
printjson(db.totalMoney.find().toArray());
