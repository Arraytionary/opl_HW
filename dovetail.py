"""this is for encounter missing-docstring in pylint"""
def iter_dovetail(*iterators):
    """this is for encounter missing-function docstring in pylint"""
    iter_dict = {}
    iter_num = len(iterators)
    for itr in range(iter_num):
        iter_dict[itr] = iterators[itr]
        for row in range(itr, -1, -1):
            temp = next(iter_dict[row], None)
            if temp is not None:
                yield temp
    while iter_dict:
        keys = list(iter_dict.keys())
        keys.sort(reverse=True)
        for row in keys:
            temp = next(iter_dict[row], None)
            if temp is not None:
                yield temp
            else:
                del iter_dict[row]
