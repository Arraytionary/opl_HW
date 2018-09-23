"""this is for encounter missing-docstring in pylint"""

def iter_alternate(iter1, iter2):
    """this is for encounter missing-function docstring in pylint"""
    i_2 = iter2
    for elm in iter1:
        yield elm
        temp = next(i_2, None)
        if temp:
            yield temp
    i2_leftover = next(i_2, None)
    while i2_leftover:
        yield i2_leftover
        i2_leftover = next(i_2, None)
