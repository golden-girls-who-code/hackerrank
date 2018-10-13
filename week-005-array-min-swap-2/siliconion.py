#!/bin/python

import math
import os
import random
import re
import sys


def rearrange(arr):
    is_sorted = True
    count = 0
    for index, value in enumerate(arr):
        correct_index = value
        if index != correct_index:
            count += 1  # you need to swap
            arr[index] = arr[value]
            arr[value] = value
            is_sorted = False
    return count, is_sorted


def minimumSwaps(arr):
    length = len(arr)
    for index, value in enumerate(arr):
        arr[index] = value - 1
        if value >= length:
            arr[index] = length - 1
    count = 0
    is_sorted = False
    while not is_sorted:
        c, is_sorted = rearrange(arr)
        count += c
    return count


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(raw_input())

    arr = map(int, raw_input().rstrip().split())



    fptr.write(str(res) + '\n')

    fptr.close()
