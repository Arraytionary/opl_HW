"""
memo_decore module
"""

def memoized(func):
    """
        Args:
            func (function): function that need to be memoized

        Returns:
            function: Function that able to memoized
    """
    mem = {}
    def memo(*args):
        if args not in mem:
            mem[args] = func(*args)
        return mem[args]
    return memo

@memoized
def fib(num):
    """
        Args:
            num (int): index of fibonacci

        Returns:
            int: value of fibonacci at num position
    """
    if num == 0:
        return 0
    if num in (1, 2):
        return 1
    return fib(num - 1) + fib(num - 2)

@memoized
def n_choose_r(n_p, r_p):
    """
        Args:
            n_p (int): Amount of number to choose from
            r_p (int): Amount of number to choose

        Returns:
            int: Number of ways to choose
    """
    if r_p == 0:
        return 1
    if n_p == r_p:
        return 1
    return n_choose_r(n_p - 1, r_p - 1) + n_choose_r(n_p - 1, r_p)
