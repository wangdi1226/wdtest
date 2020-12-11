package collection;
class Animal{
}
public class Test<E> {
    //E这样的泛型参数是不能进行实例化的
        public E[] data=(E[])new Object();
        public int usedSize;
        public void add(E data){
            this.data[usedSize]=data;
            usedSize++;
        }
        public E get(int index){
        return data[index];
        }
    public static void main(String[] args) {
     Test<Animal> animal=new Test<>();
     Test<Integer> integer=new Test<>();
     Integer num=new Integer(20);
     Integer num2=Integer.valueOf(10);
     integer.add(num);
     integer.add(num2);
     integer.add(30);
     Integer num4=integer.get(0);
        int nn=num4.intValue();


    }

}
