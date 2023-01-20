package iterator;

class MyArray {
    public Object[] num;

    public MyArray(Object[] num) {
        this.num = num;
    }

    public Iterator getAllIterator() {
        return new AllIterator();
    }

    private class AllIterator implements Iterator {
        int ind;
        public boolean hasNext() {
            if(ind < num.length) return true;
            return false;
        }
        public Object next() {
            if(this.hasNext()) return num[ind++];
            return null;
        }
    }
}
