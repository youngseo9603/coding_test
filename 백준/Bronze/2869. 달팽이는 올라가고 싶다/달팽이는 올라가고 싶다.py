import sys
import math

a, b, v = map(int, sys.stdin.readline().split())

h = a

print(math.ceil((v-a)/(a-b)) +1 )