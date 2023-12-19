// #1-1. Styling: 전역 CSS 적용
import '@/app/ui/global.css'

// #2-1 폰트 불러오기(import)
import { } from './ui/fonts';

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className={ `$inter.className` }>
        {children}
      </body>
    </html>
  );
}