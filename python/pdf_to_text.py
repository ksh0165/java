import pymupdf
import os

pdf_file_path="C:\\20260402\\readPdf\\data\\a.pdf"
doc=pymupdf.open(pdf_file_path)

full_text = ''

for page in doc:
    text=page.get_text()
    full_text += text

pdf_file_name=os.path.basename(pdf_file_path)
pdf_file_name=os.path.splitext(pdf_file_name)[0]

txt_file_path=f"C:\\20260402\\readPdf\\output\\{pdf_file_name}.txt"
with open(txt_file_path, 'w', encoding='utf-8') as f:
    f.write(full_text)


# LLM 을 활용한 AI 에이전트 개발 입문

# 실행환경 python -m venv venv
#         .\venv\Scripts\activate
