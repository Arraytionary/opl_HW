# @memoized
def memoize_fib(n):
    mem = {}
    def memo_fib(x):
        if x not in mem: 
            mem[x] = n(x)    
        return mem[x]
    return memo_fib

def fib(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)

fib = memoize_fib(fib)

def memoize_ncr(n):
    mem = {}
    def memo_ncr(x, r):
        if (x,r) not in mem: 
            mem[(x,r)] = n(x,r)    
        return mem[(x,r)]
    return memo_ncr


def n_choose_r(n, r):
    if r is 0:
        return 1
    elif n is r:
        return 1
    else:
        return n_choose_r(n - 1, r - 1) + n_choose_r(n - 1, r)

n_choose_r = memoize_ncr(n_choose_r)