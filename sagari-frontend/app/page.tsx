import Image from "next/image"

export default function Home() {
  return (
      <main className="flex min-h-screen">
          <div className="flex-1 bg-white text-black flex items-center justify-center">
              Left side
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

          <div className="flex-1 bg-dark text-light flex items-center justify-center">
              Right side
          </div>
      </main>
  );
}
