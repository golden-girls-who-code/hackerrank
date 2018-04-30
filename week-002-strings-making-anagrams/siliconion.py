from collections import Counter
def number_needed(a, b):
    dict_a = Counter(a)
    dict_b = Counter(b)
    count = 0
    for key in dict_a:
        if key in dict_b:
            count += max(0, dict_a[key] - dict_b[key])
        else:
            count += dict_a[key]
    for key in dict_b:
        if key in dict_a:
            count += max(0, dict_b[key] - dict_a[key])
        else:
            count += dict_b[key]
    return count
            

a = raw_input().strip()
b = raw_input().strip()

print number_needed(a, b)

