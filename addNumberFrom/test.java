class test implements TestInterface {
public void rec_func(int i, int j){
	if(j == 0)
		System.out.println(0);
	else{
		int value = (rec_func_h(j,0) - rec_func_h(i,0));
		System.out.println((j > i) ? (value) :  (value*-1));
	}
}
public int rec_func_h(int i, int sum){
	if(i == 0)
		return 0;
	else{
		sum += i;
		return sum + rec_func_h(i-1,sum);
	}
}
public static void main (String[] args) {
	test atest = new test();
	atest.rec_func(2,10);
}
}