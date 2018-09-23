"""this is for encounter missing-docstring in pylint"""

def stitch_files(*args):
    """this is for encounter missing-function docstring in pylint"""
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
