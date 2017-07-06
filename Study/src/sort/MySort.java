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
	
	
	
	//堆排序分为两步：1、建立堆      2、将末尾和对顶的元素对换，从堆顶进行调整。
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
	//建立堆
	private void heapCreat(int[] array) {
		if (array == null || array.length <= 1) {  
            return;  
        }  
        int half = array.length / 2;  
        for (int i = half; i >= 0; i--) {  
            maxHeap(array, array.length, i);  
        }  
	}
	//堆排序核心函数，沉降法
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
	
	
	
	
	//自制快排
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
	
	//递归求取数组中的最大值
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
	
	// 快排，时间复杂度为O（nlogn）,空间复杂度可以为O（nlogn）
	public void quick_sort(int s[], int begin, int end) {
		if (begin < end) {
			int i = begin, j = end;
			int x = s[begin];
			while (i < j) {
				while (i < j && s[j] >= x)
					// 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];
				while (i < j && s[i] < x)
					// 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, begin, i - 1); // 递归调用
			quick_sort(s, i + 1, end);
		}
	}

	// 希尔排序,渣渣排序，还是要写。
	// 插入排序的折腾版,不稳定排序，o(1)空间，
	public void shellSort(int[] arrays) {
		if (arrays == null || arrays.length <= 1) {
			return;
		}
		// 增量
		int incrementNum = arrays.length / 2;
		while (incrementNum >= 1) {
			for (int i = 0; i < arrays.length; i++) {
				// 进行插入排序
				for (int j = i; j < arrays.length - incrementNum; j = j
						+ incrementNum) {
					if (arrays[j] > arrays[j + incrementNum]) {
						int temple = arrays[j];
						arrays[j] = arrays[j + incrementNum];
						arrays[j + incrementNum] = temple;
					}
				}
			}
			// 设置新的增量
			incrementNum = incrementNum / 2;
		}
	}

	// 选择排序
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

	// 插入排序
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

	// 冒泡排序

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

	// 归并排序//时间复杂度为O（nlogn），空间复杂度为O(n)
	// 归并排序接收三个参数，数组，前后索引，以进行递归

	public int[] mergeSort(int a[], int begin, int end) {
		int mid = (begin + end) / 2;
		// 通过归并将原来数组分解为1或2个数字的数组
		if (begin < mid) {
			mergeSort(a, begin, mid);// 递归左边
			mergeSort(a, mid + 1, end);// 递归右边
			merge(a, begin, mid, end);// 合并排序
		}
		return a;
	}

	private void merge(int a[], int begin, int mid, int end) {
		// 以空间换时间，tmp为冗余数组。
		// 合并策略：左右子串按照从小到大放入冗余数组中，再将数组中的数字复制到待排序数组
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
	
	//不用其他变量交换两个变量的值
	private void change(int a,int b){
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.print(a+""+b);
	}
}
