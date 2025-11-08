import Image from "next/image"
import { FaInstagram } from 'react-icons/fa';
import { FiGithub } from 'react-icons/fi';
import Link from "next/link";

export default function Page() {
  return (
      <main className="flex min-h-screen">
          <div className={"flex-1 bg-white text-black flex items-center bg-[url('/clouds.png')]"}>
              <div className="z-41 w-80 flex flex-col gap-4 w-90 ml-28">
                  <p className="text-6xl font-[700]">Artful Expression in the Digital Realm</p>
                  <div className="flex items-center gap-3">
                      <Link href={"/arts"} className="flex bg-dark-purple-gradient rounded-md py-3 px-10 text-white cursor-pointer" >
                          Arts
                      </Link>
                      <a target="_blank" href="https://www.instagram.com/sagarkalis/" className="flex justify-center items-center bg-[#3C3C3C0D] rounded-md p-2">
                          <FaInstagram color="#545454" size={30} />
                      </a>
                  </div>
              </div>
          </div>

          <div className="fixed inset-0 z-40 flex justify-center items-center bg-transparent">
              <Image
                  src="/homepage-girl-art.png"
                  alt="Banner"
                  width={2000}
                  height={2829}
                  style={{ height: '100%', width: 'auto' }}
                  priority
              />
          </div>

          <div className={"flex-1 bg-dark background-dark-pattern"}>
              <div className="bg-transparent-orange-gradient w-full h-full text-light flex items-center justify-center">
                  <div className="z-41 w-80 flex flex-col gap-4 w-90 text-right items-end">
                      <p className="text-6xl font-[700] text-white">Navigating the Code Canvas for Excellence</p>
                      <div className="flex items-center gap-3">
                          <a target="_blank" href="https://github.com/Sagari-afk" className="flex justify-center items-center bg-white/10 rounded-md p-2">
                              <FiGithub color="white" size={30} />
                          </a>
                          <Link href={"/projects"} className="flex bg-white text-purple rounded-md py-3 px-10 cursor-pointer">
                              Project
                          </Link>
                      </div>
                  </div>
              </div>
          </div>
      </main>
  );
}
