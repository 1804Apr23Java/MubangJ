lastIndexhomework = {};

// 1)

homework.fibonacci = function(n) {

	var lastResult = 0;
	var currentResult = 1;
	var temp = 0;
	var count = 1;

	if (n === 0) {
		return 0;
	} else if (n === 1) {
		return 1;
	}

	for (j = 0; j <= n; j++) {
		temp = currentResult
		currentResult += lastResult;
		lastResult = temp;

		count++;

		if (count === n) {
			return currentResult;
		}
	}
};

// 2)

homework.sort = function(array) {

	for (i = 0; i < array.length; i++) {
		for(j = 0; j < array.length - 1; j ++) {

			if (array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}

		}
	}
	return array;
}

// 3)

homework.factorial = function(n) {
		if(n === 0) {
			return 1;
		} else {
			return n * homework.factorial(n-1);
		}
}

// 4)

homework.rotateLeft = function(array, n) {
	var tempArr = []

	for (i = 0; i < n; i++) {
		var newArray = [];

		temp = array[0];
			for (j = 1; j < array.length; j++) {
				newArray.push(array[j])
			}

			newArray.push(temp);
			array = newArray;
	}
	return newArray;

}

// 5

homework.balancedBrackets = function(bracketsString){

	var lastIndex= 0;
	var bracketArray = bracketsString.split("");
	var newArr = bracketArray.slice(0);

	for (i = 0, len = bracketsString.length; i <len; i++) {
		for (j = 0; j < newArr.length; j++ ) {

			if ( (newArr[j] === "(") || (newArr[j] === "{") || (newArr[j] === "[") ) {
				lastIndex = j;

			} else if ( (newArr[j] === ")" && newArr[lastIndex] === "(") || (newArr[j] === "]" && newArr[lastIndex] === "[") || (newArr[j] === "}" && newArr[lastIndex] === "{") ) {

				newArr.splice(lastIndex,1);
				newArr.splice(lastIndex,1);

				lastIndex-= 1;
				if (lastIndex === -1) {
					lastIndex = 0;
				}

				break;
			} else {
				return false;
			}
		}
		leftOvers = 0;
	}

	if (newArr.length === 0) {
		return true;
	} else {
		return false;
	}
};
