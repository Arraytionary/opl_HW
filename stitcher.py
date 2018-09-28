"""
stitcher module
"""
def stitch_files(*args):
    """
    Args:
        *args (str): path to the file

    Yields:
        str:  The text from each line from each file
    """
    for i in args:
        if not isinstance(i, str):
            raise ValueError("invalid type of input, expect str (%s were given)" %type(i))
        try:
            with open(i, 'r') as file:
                line = file.readline()
                while line:
                    yield line
                    line = file.readline()
            file.close()
        except IOError:
            print("file not found")
