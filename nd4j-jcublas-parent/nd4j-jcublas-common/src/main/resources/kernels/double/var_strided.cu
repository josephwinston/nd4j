#include <reduce.h>


__device__ double merge(double f1,double f2,double *extraParams) {
   return f1 + f2;
}

__device__ double update(double old,double opOutput,double *extraParams) {
       double mean = extraParams[1];
       double curr = pow(opOutput - mean,2.0);
       return old + curr;
 }


//an op for the kernel
__device__ double op(double d1,double *extraParams) {
      return d1;

}

//post process result (for things like means etc)
__device__ double postProcess(double reduction,int n,int xOffset,double *dx,int incx,double *extraParams,double *result) {
             double bias = extraParams[0];
            return  (reduction - (pow(bias,2.0) / n)) / (double) (n - 1.0);

}

extern "C"
__global__ void var_strided_double(int n, int xOffset,double *dx,int incx,double *extraParams,double *result) {
              transform(n,xOffset,dx,incx,extraParams,result);

 }


