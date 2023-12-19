// #2-1-1. Google font 추가(https://nextjs.org/learn/dashboard-app/optimizing-fonts-images#adding-a-primary-font)
import { Inter, Lusitana } from 'next/font/google';

// 외부에서 import하여 사용할 수 있도록 작성
export const inter = Inter({ subsets: ['latin'] });

// #2-1-3. 직접 폰트 추가해보기(Lusitana)
// 부가 옵션 weight: '400', '700', subset은 latin으로 적용
export const lusitana = Lusitana({ weight: ['400', '700'], subsets: ['latin'] });