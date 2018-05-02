def string_counter(input_string):
    output = {}
    for st in input_string:
        if st in output:
            output[st] += 1
        else:
            output[st] = 1
    return output
        
def ransom_note(magazine, ransom):
    magazine_dic = string_counter(magazine)
    ransom_dic = string_counter(ransom)
    for st in ransom_dic:
        if st not in magazine_dic or ransom_dic[st] > magazine_dic[st]:
            return False
    return True

m, n = map(int, raw_input().strip().split(' '))
magazine = raw_input().strip().split(' ')
ransom = raw_input().strip().split(' ')
answer = ransom_note(magazine, ransom)
if(answer):
    print "Yes"
else:
    print "No"
    
