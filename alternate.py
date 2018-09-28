"""
alternate module
"""

def iter_alternate(iter1, iter2):
    """
    Args:
        iter_1 (iterator): first parameter
        iter_2 (iterator): second parameter

    Yields:
        (some type depends on the iterator): alternate between iter_1 and iter_2
    """
    i_2_end = True
    i_2 = iter2
    for elm in iter1:
        yield elm
        try:
            temp = next(i_2)
        except StopIteration:
            i_2_end = False
        if i_2_end:
            yield temp
    for elm in i_2:
        yield elm
