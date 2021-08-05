"use strict";
export default class App {
	/**
	 * Find 2 indexes in the array that the addition gives the target number
	 * @param {Array} numberArray Array of numbers
	 * @param {number} target result expected
	 * @returns Array of indexes or empty Array
	 */
	static twoSum(numberArray, target) {
		let result = [];
		for (const number of numberArray) {
			const complement = target - number;
			if (complement > 0 && numberArray.includes(complement))
				result = [numberArray.indexOf(complement), numberArray.indexOf(number)];
		}
		return result;
	}
}

[
	{ target: 12, expect_indexes: [1, 2] },
	{ target: 34, expect_indexes: [0, 4] },
	{ target: 18, expect_indexes: [0, 3] },
	{ target: 42, expect_indexes: [] },
].forEach((expect) =>
	console.assert(
		JSON.stringify(App.twoSum([2, 4, 8, 16, 32], expect.target)) ===
			JSON.stringify(expect.expect_indexes),
		`Error Sum ${expect.target}`
	)
);
console.log("Everything is OK");
