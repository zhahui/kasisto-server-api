FROM microsoft/aspnet:1.0.0-rc1-final

RUN mkdir -p /app/Kasisto.API
COPY . /app/Kasisto.API
WORKDIR /app/Kasisto.API
RUN ["dnu", "restore"]
RUN ["dnu", "pack", "--out", "artifacts"]

EXPOSE 5000/tcp
ENTRYPOINT ["dnx", "-p", "project.json", "web"]
