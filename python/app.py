from typing import Optional, Dict
from typing import Type, TypeVar

T = TypeVar("T", bound="App")


class App:
    @classmethod
    def two_sum(
        cls: Type[T], number_list: list[int], target: int
    ) -> list[Optional[int]]:
        """Find 2 indexes in the list that the addition gives the target number

        Args:
            cls (Type[T]): App class type
            number_list (list[int]): List of numbers
            target (int): result expected

        Returns:
            list[Optional[int]]: list of indexes or empty list
        """
        for current_index, number in enumerate(number_list):
            complement: int = target - number
            if complement > 0 and complement in number_list:
                return [current_index, number_list.index(complement)]
        return []


if __name__ == "__main__":

    number_list: list[int] = [2, 4, 8, 16, 32]
    expected: Dict[int, list[Optional[int]]] = {
        12: [1, 2],
        34: [0, 4],
        18: [0, 3],
        42: [],
    }

    for target, expect_indexes in expected.items():
        assert App.two_sum(number_list, target) == expect_indexes

    print("Everything is OK")
