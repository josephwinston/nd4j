#include <transform.h>


__device__ float op(float d1,float *params) {
        return (d1 > 0) - (d1 < 0);
}

extern "C"
__global__ void sign_strided_float(int n,int idx,float *dy,int incy,float *params,float *result) {
       transform(n,idx,dy,incy,params,result);

 }