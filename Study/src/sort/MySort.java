package sort;

import java.util.Arrays;

public class MySort {

	public static void main(String arg[]) {
		int a[] = {4, 2, 3, 5, 3, 7, 9 ,6};
		MySort sort = new MySort();
		//sort.quick(a);
		// sort.mergeSort(a, 0, a.length-1);
		 //sort.quick_sort(a, 0, a.length-1);
//		sort.searchmax(a);
		//sort.quick(a);
		//sort.heapSort(a);
		sort.quick_rand(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}

	
	public void quick_rand(int[] a){
		int left = 0;
		int right = a.length-1;
		int mid = (int) (Math.random()*a.length);
		partition_rand(a, left, right,mid);
	}
	

	private void partition_rand(int[] a, int begin, int end,int rand) {
		if(begin<end){
		exchange(a, begin, rand);
		int campare=a[begin];
		int i = begin;
		int j = end;
		while(i<j){
			while(a[j]>campare &&i<j)
				j--;
			if(i<j)
				a[i++]=a[j];
			while (a[i] <= campare&&i<j) 
				i++;
			if(i<j)
				a[j--]=a[i];
			}
			a[i]=campare;
		//	int seed = (int) (Math.random()*a.length);
			partition_rand(a, begin, i-1, (int)(Math.random()*(i-1-begin+1))+begin);
			partition_rand(a,i+1,end,(int) (Math.random()*(end-i-1+1))+i+1);
		}
	}
	
	
	
	//�������Ϊ������1��������      2����ĩβ�ͶԶ���Ԫ�ضԻ����ӶѶ����е�����
	public void heapSort(int[] array){
		 if (array == null || array.length <= 1) {  
             return;  
         }  

         heapCreat(array);  

         for (int i = array.length - 1; i >= 1; i--) {  
             exchange(array, 0, i);  
             maxHeap(array, i, 0);  
         }  
	}
	//������
	private void heapCreat(int[] array) {
		if (array == null || array.length <= 1) {  
            return;  
        }  
        int half = array.length / 2;  
        for (int i = half; i >= 0; i--) {  
            maxHeap(array, array.length, i);  
        }  
	}
	//��������ĺ�����������
	 private void maxHeap(int[] array, int heapSize, int index) {  
         int left = index * 2 + 1;  
         int right = index * 2 + 2;  

         int largest = index;  
         if (left < heapSize && array[left] > array[index]) {  
             largest = left;  
         }  

         if (right < heapSize && array[right] > array[largest]) {  
             largest = right;  
         }  

         if (index != largest) {  
             exchange(array, index, largest);  

             maxHeap(array, heapSize, largest);  
         }  
     }  
	
	
	
	
	//���ƿ���
	public void quick(int a[]) {
		int begin = 0;
		int end = a.length - 1;
		partition(a, begin, end);
	}

	private void partition(int[] a, int begin, int end) {
		if(begin<end){
		int mid = a[begin];
		int i = begin;
		int j = end;
		while(i<j){
			while(a[j]>mid &&i<j)
				j--;
			if(i<j)
				a[i++]=a[j];
			while (a[i] <= mid&&i<j) 
				i++;
			if(i<j)
				a[j--]=a[i];
			}
			a[i]=mid;
			partition(a, begin, i-1);
			partition(a,i+1,end);
		}
	}

	private void  exchange(int[] in,int a ,int b) {
		int c=in[a];
		in[a]=in[b];
		in[b]=c;
	}
	
	//�ݹ���ȡ�����е����ֵ
	public void searchmax(int a[]){
		int begin = 0;
		System.out.print(max(a, begin));		
	}
	private int max(int a[],int begin){
		if(begin<a.length-1){
		int max;
		int b = max(a, begin+1);
		if(b>a[begin])
			max=b;
		else
			max=a[begin];
		return max;
		}else
			return a[a.length-1];
	}
	
	// ���ţ�ʱ�临�Ӷ�ΪO��nlogn��,�ռ临�Ӷȿ���ΪO��nlogn��
	public void quick_sort(int s[], int begin, int end) {
		if (begin < end) {
			int i = begin, j = end;
			int x = s[begin];
			while (i < j) {
				while (i < j && s[j] >= x)
					// ���������ҵ�һ��С��x����
					j--;
				if (i < j)
					s[i++] = s[j];
				while (i < j && s[i] < x)
					// ���������ҵ�һ�����ڵ���x����
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, begin, i - 1); // �ݹ����
			quick_sort(s, i + 1, end);
		}
	}

	// ϣ������,�������򣬻���Ҫд��
	// ������������ڰ�,���ȶ�����o(1)�ռ䣬
	public void shellSort(int[] arrays) {
		if (arrays == null || arrays.length <= 1) {
			return;
		}
		// ����
		int incrementNum = arrays.length / 2;
		while (incrementNum >= 1) {
			for (int i = 0; i < arrays.length; i++) {
				// ���в�������
				for (int j = i; j < arrays.length - incrementNum; j = j
						+ incrementNum) {
					if (arrays[j] > arrays[j + incrementNum]) {
						int temple = arrays[j];
						arrays[j] = arrays[j + incrementNum];
						arrays[j + incrementNum] = temple;
					}
				}
			}
			// �����µ�����
			incrementNum = incrementNum / 2;
		}
	}

	// ѡ������
	public void selectSort(int a[]) {
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = i; j < a.length - 1; j++) {
				// int min = a[i];
				if (a[i] > a[j]) {
					int b = a[i];
					a[i] = a[j];
					a[j] = b;
				}
			}
		}
	}

	// ��������
	public int[] insertSort(int a[]) {
		for (int i = 1; i < a.length - 1; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					int b = a[i];
					int c = i;
					int d = j;
					while (c != d) {
						a[c] = a[c - 1];
						c--;
					}
					a[j] = b;
				}
			}
		}
		return a;
	}

	// ð������

	public int[] maopaoSort(int a[]) {
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int c = a[j];
					a[j] = a[j + 1];
					a[j + 1] = c;
				}
			}
		}
		return a;
	}

	// �鲢����//ʱ�临�Ӷ�ΪO��nlogn�����ռ临�Ӷ�ΪO(n)
	// �鲢��������������������飬ǰ���������Խ��еݹ�

	public int[] mergeSort(int a[], int begin, int end) {
		int mid = (begin + end) / 2;
		// ͨ���鲢��ԭ������ֽ�Ϊ1��2�����ֵ�����
		if (begin < mid) {
			mergeSort(a, begin, mid);// �ݹ����
			mergeSort(a, mid + 1, end);// �ݹ��ұ�
			merge(a, begin, mid, end);// �ϲ�����
		}
		return a;
	}

	private void merge(int a[], int begin, int mid, int end) {
		// �Կռ任ʱ�䣬tmpΪ�������顣
		// �ϲ����ԣ������Ӵ����մ�С����������������У��ٽ������е����ָ��Ƶ�����������
		int[] tmp = new int[end - begin + 1];
		int i = begin;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		while (i <= mid) {
			tmp[k++] = a[i++];
		}
		while (j <= end) {
			tmp[k++] = a[j++];
		}
		for (int m = 0; m < tmp.length; m++) {
			a[m + begin] = tmp[m];
		}
	}
	
	//��������������������������ֵ
	private void change(int a,int b){
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.print(a+""+b);
	}
}
