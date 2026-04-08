import asyncio

# 비동기 버전 -- 동시 실행 (총 1초)
async def async_version():
    await asyncio.gather(
        delayed_print(1, "작업 1 완료"),
        delayed_print(1, "작업 2 완료"),
        delayed_print(1, "작업 3 완료"),
    )

async def delayed_print(delay, message):
    await asyncio.sleep(delay)
    print(message)

async def main():
    await async_version()


asyncio.run(main())
