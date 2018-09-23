"""this is for encounter missing-docstring in pylint"""

def all_perms(input_number):
    """this is for encounter missing-function docstring in pylint"""
    if input_number == 1:
        yield (1, )
    else:
        prev = all_perms(input_number - 1)
        for elm in prev:
            for pos in range(input_number - 1, -1, -1):
                temporary = list(elm)
                temporary.insert(pos, input_number)
                yield tuple(temporary)
