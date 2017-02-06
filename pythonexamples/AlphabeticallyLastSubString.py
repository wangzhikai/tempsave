'''
Created on Feb 6, 2017
#sort all the substrings, return the last alphabetical one
@author: zhikai
'''
import unittest

def getLast(s):
    #d = dict()
    a = []
    for i in range(0,len(s)-1):
        #print i
        lmax = len(s)-i+1
        for l in range(1,lmax):
            #print l
            t = s[i:i+l]
            #print t
            #d[t]=t
            a.append(t) 
    #print d
    s = sorted(set(a))
           
    if len(s) > 0 :
        r = s[len(s)-1]
        
        
    return r


class Test(unittest.TestCase):

    def testName(self):
        #getLast("banana")
        self.assertEqual(getLast("banana"), 'nana')
#         print getLast("banana")
        pass
    
    def testName2(self):
        pass


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()