# @memoized
def memorize_fib(n):
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

lib = memorize_fib(fib)