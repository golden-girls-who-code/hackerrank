def number_needed(a, b):
    intersection = set(a) & set(b)
    repeated = 0
    for letter in intersection:
        if a.count(letter) > b.count(letter):
            repeated = repeated + b.count(letter)
        else:
            repeated = repeated + a.count(letter)
    return len(a) + len(b) - 2 * repeated;

a = input().strip()
b = input().strip()

print(number_needed(a, b))
