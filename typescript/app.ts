export default class App {
	/**
	 * Find 2 indexes in the array that the addition gives the target number
	 * @param {Array} numberArray Array of numbers
	 * @param {number} target result expected
	 * @returns Array of indexes or empty Array
	 */
	static twoSum(numberArray: Array<number>, target: number): Array<number> {
		let result: Array<number> = [];
		for (const number of numberArray) {
			const complement: number = target - number;
			if (complement > 0 && numberArray.includes(complement)) {
				result = [numberArray.indexOf(number), numberArray.indexOf(complement)];
				break;
			}
		}
		return result;
	}
}

interface Expected {
	target: number;
	expect_indexes: Array<number>;
}

[
	{ target: 12, expect_indexes: [1, 2] },
	{ target: 34, expect_indexes: [0, 4] },
	{ target: 18, expect_indexes: [0, 3] },
	{ target: 42, expect_indexes: [] },
].forEach((expect: Expected) =>
	console.assert(
		JSON.stringify(App.twoSum([2, 4, 8, 16, 32], expect.target)) ===
			JSON.stringify(expect.expect_indexes),
		new Error(`Sum for total of "${expect.target}"`)
	)
);

console.log("Everything is OK");
