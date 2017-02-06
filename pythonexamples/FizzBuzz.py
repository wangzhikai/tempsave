'''
Created on Feb 6, 2017

@author: zhikai
'''
def fizzbuzz(input):
    for i in input:
        if i % 3 == 0:
            if i % 5 == 0 :
                print "FizzBuzz"
            else:
                print "Fizz"
        elif i % 5 == 0:
            print "Buzz"
        else:
            print i

fizzbuzz([3,4,5,6,7,8,9,18,25,29,30])
            
        
    