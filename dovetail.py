"""
dovetail module
"""
def iter_dovetail(*iterators):
    """
    Args:
        *iterators (iterator): Iterators to perform the dovetailing

    Yields:
        (some type depends on the iterator): The value from iterator by doing dovetail operation
    """
    iter_dict = {}
    iter_num = len(iterators)
    for itr in range(iter_num):
        iter_dict[itr] = [iterators[itr], True]
        for row in range(itr, -1, -1):
            try:
                temp = next(iter_dict[row][0])
            except StopIteration:
                iter_dict[row][1] = False
            if iter_dict[row][1]:
                yield temp
    while iter_dict:
        keys = list(iter_dict.keys())
        keys.sort(reverse=True)
        for row in keys:
            try:
                temp = next(iter_dict[row][0])
            except StopIteration:
                iter_dict[row][1] = False
            if iter_dict[row][1]:
                yield temp
            else:
                del iter_dict[row]
