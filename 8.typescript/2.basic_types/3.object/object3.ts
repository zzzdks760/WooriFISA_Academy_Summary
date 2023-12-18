export {};

type CookieWithCompany = {
    name: string;
    company: string;
}

type CookieWithTaste = {
    name: string;
    taste: string;
}

type Cookie = CookieWithCompany | CookieWithTaste;

const firstCookie: Cookie = Math.random() > 0.5
    ? { name: 'OREO', company: 'Nabisco' } : { name: 'OREO', taste: 'Choco'};

if ('company' in firstCookie) {
    firstCookie.company;
} else {
    firstCookie.taste;
}