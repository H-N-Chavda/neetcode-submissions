class Solution:
    def calPoints(self, operations: List[str]) -> int:
        result = []
        for i in range(len(operations)):
            if operations[i] == "+":
                result.append(result[-1] + result[-2])
            elif operations[i] == "C":
                result.pop()
            elif operations[i] == "D":
                result.append(2*result[-1])
            else:
                result.append(int(operations[i]))
        return sum(result)