class test implements TestInterface {
public void rec_func(int x, int sum){
	if(x == 0)
		System.out.println(sum);
	else{
		sum += x;
		rec_func(x-1,sum);
	}
}
public static void main (String[] args) {
	test atest = new test();
	atest.rec_func(10,0);
}
}