 class Numbers {
        public int a;
        public int b;

        public Numbers(int c) {
            a=c;
            b=c*2;
        }

        @Override
        public String toString() {
            return("a: "+a+" b: "+b);
        }
    }
    class Main {
        public static void main(String[] args) {
            Numbers n1= new Numbers(2);
            System.out.println(n1);
        }
    }