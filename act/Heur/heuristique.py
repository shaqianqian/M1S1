"""
    Liste_different_depart :
    param : une liste de taches
    return :la liste des differents départs
    Par exemple :
    [(0,50,1200),(0,20,3600),(0,20,3600),(0,20,3600),(2400,75,120),(3000,15,7200),(3400,42,1337)]
    
    doit renvoyer :
    
    [0,2400,3000,3400]
"""

def liste_different_depart (jobs) :
    liste = []
    for tache in jobs :
        liste.append(tache[0])
    return list(set(liste))

"""
    organisation_petite_tache:
    param : nombre de machine et une liste de taches
    return :la liste de l'ordre d'execution des taches
    Par exemple :
    [(0,50,1200),(0,20,3600),(0,20,3600),(0,20,3600)]
    
    doit renvoyer :
    
    [(0, 20, 3600), (0, 20, 3600), (0, 20, 3600), (3600, 50, 1200)]
"""


def organisation_petite_tache (m,jobs) :
    nombre_machine = m
    compteur_temps = 0
    taches_non_effectuees = jobs
    taches_effectuees = []
    res=[]
    for i in range (0,(len(jobs))) :
        minimum = min(taches_non_effectuees)
        if (nombre_machine > minimum[1]) :  
            taches_non_effectuees.remove(minimum)
            taches_effectuees.append(tuple(reversed(minimum)))
            res.append(minimum)
            nombre_machine = nombre_machine - minimum[1]
        else :
            while (nombre_machine < minimum[1]) :
                compteur_temps = (min(taches_effectuees))[0]
                nombre_machine = nombre_machine + ((min(taches_effectuees))[1])
                taches_effectuees.remove(min(taches_effectuees))
            minimum = (compteur_temps,minimum[1],minimum[2])
            res.append(minimum)
            nombre_machine = nombre_machine - minimum[1]
    return res
"""
    calcul_delai :
    param : un nombre de machine, une liste de taches avec toute la meme date d'arrivée
    return : (nombre machine restante, liste d'execution optimale, liste des taches restantes)
    Par exemple pour :
    (100, [(0,50,1200),(0,20,3600),(0,20,3600),(0,20,3600)])
    doit renvoyer :
    (10,[(0,50,1200),(0,20,3600),(0,20,3600)], (0,20,3600)])


def calcul_delai (m, jobs) :
    nombre_machine = m
    for t in jobs :

"""

"""
def petite_tache_dabord (m, n, jobs) :
    l = []
    for a in liste_different_depart (jobs) :
        for b in jobs :
            if b[0] == a :
                l.append(b)
        
"""


"""
    naive :
    param : nombre de machines, nombre de taches, une liste de taches
    return :une liste correspondant a la date de debut de chaque tache

    Par exemple :
    naive (100,7,[(0,50,1200),(0,20,3600),(0,20,3600),(0,20,3600),(2400,75,120),(3000,15,7200),(3400,42,1337)])

    doit renvoyer :
    [0, 0, 0, 1200, 3600, 3720, 3720]

"""

def naive (m,n,jobs) :
    nombre_machine = m
    compteur_temps = 0
    taches_effectuees = []
    res=[]
    for i in jobs :
        if i[0] > compteur_temps :
            compteur_temps = i[0]
        if (nombre_machine > i[1]) :
            taches_effectuees.append((i[2],i[1],compteur_temps))
            res.append(compteur_temps)
            nombre_machine = nombre_machine - i[1]
        else :
            while (nombre_machine < i[1]) :
                if (min(taches_effectuees))[0] < compteur_temps :
                    compteur_temps = compteur_temps + (min(taches_effectuees))[0]
                else :
                    compteur_temps = (min(taches_effectuees))[0]
                nombre_machine = nombre_machine + ((min(taches_effectuees))[1])
                taches_effectuees.remove(min(taches_effectuees))
            res.append(compteur_temps)
            temp = taches_effectuees
            for t in temp :
                if t[0] < compteur_temps :
                    nombre_machine = nombre_machine + t[1]
                    taches_effectuees.remove(t)
            nombre_machine = nombre_machine - i[1]
            taches_effectuees = temp
            taches_effectuees.append((i[2],i[1],compteur_temps))
    return res
  
