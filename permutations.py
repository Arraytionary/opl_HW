"""
permutation module
"""

def all_perms(input_number):
    """
    Args:
        input_number (int): An integer input_number > 0 

    Yileds:
        tuple: permutation of number 1, 2, ..., input_number
    """
    if input_number == 1:
        yield (1, )
    else:
        prev = all_perms(input_number - 1)
        for elm in prev:
            for pos in range(input_number - 1, -1, -1):
                temporary = list(elm)
                temporary.insert(pos, input_number)
                yield tuple(temporary)
