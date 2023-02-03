import sys

while(True):
    sentence = input()
    if sentence == ".":
        break

    for i in sentence:
        if i != "(" and i != ")" and i != "[" and i != "]":
            sentence = sentence.replace(i,"")
    for i in range(len(sentence)//2):
        if "()" in sentence:
            sentence = sentence.replace("()",'')
        elif "[]" in sentence:
            sentence = sentence.replace("[]", '')
    if sentence == "":
        print("yes")
    else:
        print("no")