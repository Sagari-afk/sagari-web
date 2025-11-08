"use client";
import Logo from "next/image";
import Link from "next/link";


export default function Header() {
    return (
        <div className="fixed top-0 left-0 w-full z-50 ">
            <div className="w-full flex flex-row justify-between align-items-center backdrop-blur-xs py-2 px-20 bg-white/5">
                <Link href="/">
                    <Logo src="/Sagari-logo.png" alt="Sagari" width={182} height={43}></Logo>
                </Link>

                <div className="flex flex-wrap items-center gap-9">
                    <Link href={"/arts"} className="text-md font-[400] text-light">Arts</Link>
                    <Link href={"/projects"} className="text-md font-[400] text-light">Projects</Link>
                    {/*<Link href={"/projects"} className="text-md font-[400] text-light">Dance</Link>*/}
                    <Link href={"/about"} className="text-md font-[400] text-light-purple bg-semitransparent-purple
                                                    px-4 py-2 rounded-sm">About</Link>
                    {/*<Link href={"/logIn"} className="text-md font-[400] text-light-purple bg-semitransparent-purple*/}
                    {/*                            px-4 py-2 rounded-sm">Log in</Link>*/}
                </div>
            </div>
        </div>
    )
}