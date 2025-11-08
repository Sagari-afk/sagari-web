import Image from "next/image";

export default function ArtsCarousel() {
    return (
        <Image src="/noImage.jpeg"
               alt="Banner"
               width={2000}
               height={2829}
               style={{ height: '100%', width: 'auto' }}/>
    )
}