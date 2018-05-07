from collections import Counter

def ransom_note(magazine, ransom):
    if not set(ransom) - set(magazine):
        return duplicate_words(magazine, ransom)
    else:
        return False

def duplicate_words(magazine, ransom):
    magazine_words = Counter(magazine)
    ransom_words = Counter(ransom)
    for word in ransom:
        if magazine_words[word] < ransom_words[word]:
            return False
    return True
        
m, n = map(int, input().strip().split(' '))
magazine = input().strip().split(' ')
ransom = input().strip().split(' ')
answer = ransom_note(magazine, ransom)
if(answer):
    print("Yes")
else:
    print("No")
